/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverwofacade;
public class ServerWOFacade {
    
    private static ServerWOFacade myFacadeObj = null;
    private ServerWOFacade(){}
    public static ServerWOFacade getMyFacadeObject(){
        if (myFacadeObj == null){
            myFacadeObj = new ServerWOFacade();
        }
        return myFacadeObj;
    }
    
    public void start() {
    ScheduleServer obj = new ScheduleServer();
    obj.startBooting();
    obj.readSystemConfigFile();
    obj.init();
    obj.initializeContext();
    obj.initializeListeners();
    obj.createSystemObjects();}
    
    
     public void stop() {
    ScheduleServer obj = new ScheduleServer();
    obj.releaseProcesses();
    obj.destory();
    obj.destroySystemObjects();
    obj.destoryListeners();
    obj.destoryContext();
    obj.shutdown();}
    
    
    
    public static void main(String[] args) {
        ServerWOFacade obj = ServerWOFacade.getMyFacadeObject();
        obj.start();
        obj.stop();
    }
    
}
