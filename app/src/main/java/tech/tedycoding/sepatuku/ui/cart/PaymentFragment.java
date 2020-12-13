package tech.tedycoding.sepatuku.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback;
import com.midtrans.sdk.corekit.core.MidtransSDK;
import com.midtrans.sdk.corekit.core.PaymentType;
import com.midtrans.sdk.corekit.core.UIKitCustomSetting;
import com.midtrans.sdk.corekit.core.themes.CustomColorTheme;
import com.midtrans.sdk.corekit.models.snap.TransactionResult;
import com.midtrans.sdk.uikit.SdkUIFlowBuilder;

import tech.tedycoding.sepatuku.R;
import tech.tedycoding.sepatuku.BuildConfig;
import tech.tedycoding.sepatuku.model.CustomerModel;

public class PaymentFragment extends Fragment implements TransactionFinishedCallback{
    private Button btnPayment;
    public PaymentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnPayment = view.findViewById(R.id.btnPayNow);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initMidtransSDK();
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MidtransSDK.getInstance().setTransactionRequest(CustomerModel.transactionRequest(
                        "TC001",
                        500000,
                        1,
                        "ADIDAS KW"
                ));
                MidtransSDK.getInstance().startPaymentUiFlow(getActivity(), PaymentType.KLIK_BCA);
            }
        });
    }

    private void initMidtransSDK() {
        UIKitCustomSetting uisetting = new UIKitCustomSetting();
        uisetting.setShowPaymentStatus(true);
        uisetting.setSkipCustomerDetailsPages(true);

        SdkUIFlowBuilder.init()
                .setContext(getActivity())
                .setMerchantBaseUrl(BuildConfig.BASE_URL)
                .setClientKey(BuildConfig.CLIENT_KEY)
                .setTransactionFinishedCallback(this)
                .enableLog(true)
                .setColorTheme(new CustomColorTheme("#174EE6", "#1A45BC", "#2C60EF"))
//                .setUIkitCustomSetting(uisetting)
                .buildSDK();
    }

    @Override
    public void onTransactionFinished(TransactionResult result) {
        if(result.getResponse() != null){
            switch (result.getStatus()){
                case TransactionResult.STATUS_SUCCESS :
                    Toast.makeText(getActivity(), "Transaksi Sukses dengan id " + result.getResponse().getTransactionId() , Toast.LENGTH_SHORT).show();
                    break;
                case TransactionResult.STATUS_PENDING :
                Toast.makeText(getActivity(), "Tertunda Tertunda dengan id " + result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;
                case TransactionResult.STATUS_FAILED :
                Toast.makeText(getActivity(), "Tertunda Gagal dengan id " + result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;
            }
            result.getResponse().getValidationMessages();
        } else if (result.isTransactionCanceled()){
            Toast.makeText(getActivity(), "Transaksi Dibatalkan", Toast.LENGTH_SHORT).show();
        } else {
            if (result.getStatus().equalsIgnoreCase(TransactionResult.STATUS_INVALID)){
                Toast.makeText(getActivity(), "Transaksi Invalid ", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Transaksi Finish with Fail", Toast.LENGTH_SHORT).show();
            }
        }
    }
}