
// e.g. #1
android.util.Log.d(TAG, "msg", new RuntimeException().fillInStackTrace());

// e.g. #2
String callers = android.os.Debug.getCallers(10);

// e.g. #3
Boolean isCallByCTS(){
    boolean isCTS=false;
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    String temp="",fullName="",callPkg="";
    for(int i =0;i<stackTraceElements.length;i++){
        fullName = stackTraceElements[i].getClassName();
        temp =fullName.substring(0,fullName.lastIndexOf('.'));
        //Log.d(TAG,"isCallByCTS:package="+temp);
        if(temp.equals("android.bluetooth.cts") ){
            isCTS=true;
            break;
        }
    }
    return isCTS;
}