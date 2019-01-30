package io.electrum.airtime.utils;

/**
 * Use path constants defined in {@link io.electrum.billpay.api.AccountLookupsResource}, 
 * {@link io.electrum.billpay.api.PaymentsResource} and 
 * {@link io.electrum.billpay.api.RefundsResource}.
 */
@Deprecated
public class Paths {

   // Voucher lookup paths
   public static final String VOUCHER_BASE_PATH = "/voucher";

   public static final String VOUCHER_REQUEST = VOUCHER_BASE_PATH  + "/{" + PathParams.REQUEST_ID + "}";
   public static final String VOUCHER_CONFIRMATION =
   VOUCHER_BASE_PATH + "/confirmations/{" + PathParams.ADVICE_ID + "}";
   public static final String VOUCHER_REVERSAL =
   VOUCHER_BASE_PATH +"/{" + PathParams.Voucher_ID + "}/reversals/{" + PathParams.ADVICE_ID + "}";

   // Purchase paths
   public static final String PURCHASE_BASE_PATH = "/purchase";

   public static final String PURCHASE_REQUEST = PURCHASE_BASE_PATH + "/{" + PathParams.Purchase_ID + "}";;
   public static final String PURCHASE_CONFIRMATION =
            PURCHASE_BASE_PATH + "/confirmations/{" + PathParams.Purchase_ID + "}";
   public static final String PURCHASE_STATUS_REQUEST = PURCHASE_BASE_PATH + "/{" + PathParams.Purchase_ID + "}";
   public static final String PURCHASE_REVERSAL =
            PURCHASE_BASE_PATH + "/{" + PathParams.Purchase_ID + "}/reversals/{" + PathParams.ADVICE_ID + "}";
   
   // MSISDN paths
   public static final String MSISDN_BASE_PATH = "/msisdn";
   public static final String MSISDN_INFO_REQUEST = MSISDN_BASE_PATH + "/{" + PathParams.MSISDN_ID + "}";
}
