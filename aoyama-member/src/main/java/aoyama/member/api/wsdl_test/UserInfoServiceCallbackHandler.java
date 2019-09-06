/**
 * UserInfoServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package aoyama.member.api.wsdl_test;


/**
 *  UserInfoServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class UserInfoServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public UserInfoServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public UserInfoServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for getUserData2 method
     * override this method for handling normal response from getUserData2 operation
     */
    public void receiveResultgetUserData2(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetUserData2ResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUserData2 operation
     */
    public void receiveErrorgetUserData2(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUserInfoArray2 method
     * override this method for handling normal response from getUserInfoArray2 operation
     */
    public void receiveResultgetUserInfoArray2(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetUserInfoArray2ResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUserInfoArray2 operation
     */
    public void receiveErrorgetUserInfoArray2(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for setPointInfoWebArray method
     * override this method for handling normal response from setPointInfoWebArray operation
     */
    public void receiveResultsetPointInfoWebArray(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.SetPointInfoWebArrayResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from setPointInfoWebArray operation
     */
    public void receiveErrorsetPointInfoWebArray(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for setPointInfo method
     * override this method for handling normal response from setPointInfo operation
     */
    public void receiveResultsetPointInfo(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.SetPointInfoResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from setPointInfo operation
     */
    public void receiveErrorsetPointInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCouponArray method
     * override this method for handling normal response from getCouponArray operation
     */
    public void receiveResultgetCouponArray(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetCouponArrayResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCouponArray operation
     */
    public void receiveErrorgetCouponArray(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getPurchaseArray2 method
     * override this method for handling normal response from getPurchaseArray2 operation
     */
    public void receiveResultgetPurchaseArray2(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetPurchaseArray2ResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getPurchaseArray2 operation
     */
    public void receiveErrorgetPurchaseArray2(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for setNonMemberData method
     * override this method for handling normal response from setNonMemberData operation
     */
    public void receiveResultsetNonMemberData(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.SetNonMemberDataResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from setNonMemberData operation
     */
    public void receiveErrorsetNonMemberData(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getEncryptKokNo method
     * override this method for handling normal response from getEncryptKokNo operation
     */
    public void receiveResultgetEncryptKokNo(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetEncryptKokNoResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getEncryptKokNo operation
     */
    public void receiveErrorgetEncryptKokNo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUserPointArray method
     * override this method for handling normal response from getUserPointArray operation
     */
    public void receiveResultgetUserPointArray(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetUserPointArrayResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUserPointArray operation
     */
    public void receiveErrorgetUserPointArray(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUserDataByEmail method
     * override this method for handling normal response from getUserDataByEmail operation
     */
    public void receiveResultgetUserDataByEmail(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetUserDataByEmailResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUserDataByEmail operation
     */
    public void receiveErrorgetUserDataByEmail(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getPurchaseArray method
     * override this method for handling normal response from getPurchaseArray operation
     */
    public void receiveResultgetPurchaseArray(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetPurchaseArrayResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getPurchaseArray operation
     */
    public void receiveErrorgetPurchaseArray(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUserInfo2 method
     * override this method for handling normal response from getUserInfo2 operation
     */
    public void receiveResultgetUserInfo2(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetUserInfo2ResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUserInfo2 operation
     */
    public void receiveErrorgetUserInfo2(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for setUserInfo2 method
     * override this method for handling normal response from setUserInfo2 operation
     */
    public void receiveResultsetUserInfo2(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.SetUserInfo2ResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from setUserInfo2 operation
     */
    public void receiveErrorsetUserInfo2(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getPastelPurchaseArray method
     * override this method for handling normal response from getPastelPurchaseArray operation
     */
    public void receiveResultgetPastelPurchaseArray(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetPastelPurchaseArrayResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getPastelPurchaseArray operation
     */
    public void receiveErrorgetPastelPurchaseArray(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for setUserInfo method
     * override this method for handling normal response from setUserInfo operation
     */
    public void receiveResultsetUserInfo(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.SetUserInfoResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from setUserInfo operation
     */
    public void receiveErrorsetUserInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for setCouponArray method
     * override this method for handling normal response from setCouponArray operation
     */
    public void receiveResultsetCouponArray(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.SetCouponArrayResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from setCouponArray operation
     */
    public void receiveErrorsetCouponArray(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getDecryptKokNo method
     * override this method for handling normal response from getDecryptKokNo operation
     */
    public void receiveResultgetDecryptKokNo(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetDecryptKokNoResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getDecryptKokNo operation
     */
    public void receiveErrorgetDecryptKokNo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for setCcmArray method
     * override this method for handling normal response from setCcmArray operation
     */
    public void receiveResultsetCcmArray(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.SetCcmArrayResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from setCcmArray operation
     */
    public void receiveErrorsetCcmArray(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCustomerNo method
     * override this method for handling normal response from getCustomerNo operation
     */
    public void receiveResultgetCustomerNo(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetCustomerNoResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCustomerNo operation
     */
    public void receiveErrorgetCustomerNo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUserData method
     * override this method for handling normal response from getUserData operation
     */
    public void receiveResultgetUserData(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetUserDataResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUserData operation
     */
    public void receiveErrorgetUserData(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUserInfoArray method
     * override this method for handling normal response from getUserInfoArray operation
     */
    public void receiveResultgetUserInfoArray(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetUserInfoArrayResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUserInfoArray operation
     */
    public void receiveErrorgetUserInfoArray(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUserInfo method
     * override this method for handling normal response from getUserInfo operation
     */
    public void receiveResultgetUserInfo(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetUserInfoResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUserInfo operation
     */
    public void receiveErrorgetUserInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCouponMst method
     * override this method for handling normal response from getCouponMst operation
     */
    public void receiveResultgetCouponMst(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetCouponMstResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCouponMst operation
     */
    public void receiveErrorgetCouponMst(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for setCustomerServiceInfo method
     * override this method for handling normal response from setCustomerServiceInfo operation
     */
    public void receiveResultsetCustomerServiceInfo(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.SetCustomerServiceInfoResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from setCustomerServiceInfo operation
     */
    public void receiveErrorsetCustomerServiceInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCardInfo method
     * override this method for handling normal response from getCardInfo operation
     */
    public void receiveResultgetCardInfo(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetCardInfoResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCardInfo operation
     */
    public void receiveErrorgetCardInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getPointInfo method
     * override this method for handling normal response from getPointInfo operation
     */
    public void receiveResultgetPointInfo(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetPointInfoResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getPointInfo operation
     */
    public void receiveErrorgetPointInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for setUserInfoWebArray2 method
     * override this method for handling normal response from setUserInfoWebArray2 operation
     */
    public void receiveResultsetUserInfoWebArray2(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.SetUserInfoWebArray2ResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from setUserInfoWebArray2 operation
     */
    public void receiveErrorsetUserInfoWebArray2(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCustomerServiceList method
     * override this method for handling normal response from getCustomerServiceList operation
     */
    public void receiveResultgetCustomerServiceList(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetCustomerServiceListResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCustomerServiceList operation
     */
    public void receiveErrorgetCustomerServiceList(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for setUserInfoWebArray method
     * override this method for handling normal response from setUserInfoWebArray operation
     */
    public void receiveResultsetUserInfoWebArray(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.SetUserInfoWebArrayResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from setUserInfoWebArray operation
     */
    public void receiveErrorsetUserInfoWebArray(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getNonMemberData method
     * override this method for handling normal response from getNonMemberData operation
     */
    public void receiveResultgetNonMemberData(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetNonMemberDataResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getNonMemberData operation
     */
    public void receiveErrorgetNonMemberData(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUserArray2 method
     * override this method for handling normal response from getUserArray2 operation
     */
    public void receiveResultgetUserArray2(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetUserArray2ResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUserArray2 operation
     */
    public void receiveErrorgetUserArray2(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCustomerServiceItem method
     * override this method for handling normal response from getCustomerServiceItem operation
     */
    public void receiveResultgetCustomerServiceItem(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetCustomerServiceItemResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCustomerServiceItem operation
     */
    public void receiveErrorgetCustomerServiceItem(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCsStatusList method
     * override this method for handling normal response from getCsStatusList operation
     */
    public void receiveResultgetCsStatusList(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetCsStatusListResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCsStatusList operation
     */
    public void receiveErrorgetCsStatusList(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getClientList method
     * override this method for handling normal response from getClientList operation
     */
    public void receiveResultgetClientList(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetClientListResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getClientList operation
     */
    public void receiveErrorgetClientList(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCustomerServiceAlarm method
     * override this method for handling normal response from getCustomerServiceAlarm operation
     */
    public void receiveResultgetCustomerServiceAlarm(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetCustomerServiceAlarmResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCustomerServiceAlarm operation
     */
    public void receiveErrorgetCustomerServiceAlarm(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for setMeasureringInfo method
     * override this method for handling normal response from setMeasureringInfo operation
     */
    public void receiveResultsetMeasureringInfo(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.SetMeasureringInfoResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from setMeasureringInfo operation
     */
    public void receiveErrorsetMeasureringInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getMeasureringInfo method
     * override this method for handling normal response from getMeasureringInfo operation
     */
    public void receiveResultgetMeasureringInfo(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetMeasureringInfoResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getMeasureringInfo operation
     */
    public void receiveErrorgetMeasureringInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUserArray method
     * override this method for handling normal response from getUserArray operation
     */
    public void receiveResultgetUserArray(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetUserArrayResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUserArray operation
     */
    public void receiveErrorgetUserArray(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUserPoint method
     * override this method for handling normal response from getUserPoint operation
     */
    public void receiveResultgetUserPoint(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetUserPointResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUserPoint operation
     */
    public void receiveErrorgetUserPoint(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for setCcmArray2 method
     * override this method for handling normal response from setCcmArray2 operation
     */
    public void receiveResultsetCcmArray2(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.SetCcmArray2ResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from setCcmArray2 operation
     */
    public void receiveErrorsetCcmArray2(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUserPointArray2 method
     * override this method for handling normal response from getUserPointArray2 operation
     */
    public void receiveResultgetUserPointArray2(
        aoyama.member.api.wsdl_test.UserInfoServiceStubTest.GetUserPointArray2ResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUserPointArray2 operation
     */
    public void receiveErrorgetUserPointArray2(java.lang.Exception e) {
    }
}
