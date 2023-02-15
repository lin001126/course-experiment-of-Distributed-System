
package clientcode;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserServiceImpl", targetNamespace = "http://server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserServiceImpl {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMeetingList", targetNamespace = "http://server/", className = "server.GetMeetingList")
    @ResponseWrapper(localName = "getMeetingListResponse", targetNamespace = "http://server/", className = "server.GetMeetingListResponse")
    @Action(input = "http://server/UserServiceImpl/getMeetingListRequest", output = "http://server/UserServiceImpl/getMeetingListResponse")
    public String getMeetingList();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteMeet", targetNamespace = "http://server/", className = "server.DeleteMeet")
    @ResponseWrapper(localName = "deleteMeetResponse", targetNamespace = "http://server/", className = "server.DeleteMeetResponse")
    @Action(input = "http://server/UserServiceImpl/deleteMeetRequest", output = "http://server/UserServiceImpl/deleteMeetResponse")
    public String deleteMeet(
        @WebParam(name = "arg0", targetNamespace = "")
        List<String> arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkId", targetNamespace = "http://server/", className = "server.CheckId")
    @ResponseWrapper(localName = "checkIdResponse", targetNamespace = "http://server/", className = "server.CheckIdResponse")
    @Action(input = "http://server/UserServiceImpl/checkIdRequest", output = "http://server/UserServiceImpl/checkIdResponse")
    public boolean checkId(
        @WebParam(name = "arg0", targetNamespace = "")
        List<String> arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addMeet", targetNamespace = "http://server/", className = "server.AddMeet")
    @ResponseWrapper(localName = "addMeetResponse", targetNamespace = "http://server/", className = "server.AddMeetResponse")
    @Action(input = "http://server/UserServiceImpl/addMeetRequest", output = "http://server/UserServiceImpl/addMeetResponse")
    public String addMeet(
        @WebParam(name = "arg0", targetNamespace = "")
        List<String> arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "clearMeet", targetNamespace = "http://server/", className = "server.ClearMeet")
    @ResponseWrapper(localName = "clearMeetResponse", targetNamespace = "http://server/", className = "server.ClearMeetResponse")
    @Action(input = "http://server/UserServiceImpl/clearMeetRequest", output = "http://server/UserServiceImpl/clearMeetResponse")
    public String clearMeet(
        @WebParam(name = "arg0", targetNamespace = "")
        List<String> arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "registry", targetNamespace = "http://server/", className = "server.Registry")
    @ResponseWrapper(localName = "registryResponse", targetNamespace = "http://server/", className = "server.RegistryResponse")
    @Action(input = "http://server/UserServiceImpl/registryRequest", output = "http://server/UserServiceImpl/registryResponse")
    public String registry(
        @WebParam(name = "arg0", targetNamespace = "")
        List<String> arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws ParseException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "queryMeet", targetNamespace = "http://server/", className = "server.QueryMeet")
    @ResponseWrapper(localName = "queryMeetResponse", targetNamespace = "http://server/", className = "server.QueryMeetResponse")
    @Action(input = "http://server/UserServiceImpl/queryMeetRequest", output = "http://server/UserServiceImpl/queryMeetResponse", fault = {
        @FaultAction(className = ParseException_Exception.class, value = "http://server/UserServiceImpl/queryMeet/Fault/ParseException")
    })
    public String queryMeet(
        @WebParam(name = "arg0", targetNamespace = "")
        List<String> arg0)
        throws ParseException_Exception
    ;

}