
package clientcode;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddMeet_QNAME = new QName("http://server/", "addMeet");
    private final static QName _QueryMeetResponse_QNAME = new QName("http://server/", "queryMeetResponse");
    private final static QName _ClearMeet_QNAME = new QName("http://server/", "clearMeet");
    private final static QName _GetMeetingList_QNAME = new QName("http://server/", "getMeetingList");
    private final static QName _CheckIdResponse_QNAME = new QName("http://server/", "checkIdResponse");
    private final static QName _QueryMeet_QNAME = new QName("http://server/", "queryMeet");
    private final static QName _AddMeetResponse_QNAME = new QName("http://server/", "addMeetResponse");
    private final static QName _GetMeetingListResponse_QNAME = new QName("http://server/", "getMeetingListResponse");
    private final static QName _Registry_QNAME = new QName("http://server/", "registry");
    private final static QName _CheckId_QNAME = new QName("http://server/", "checkId");
    private final static QName _ParseException_QNAME = new QName("http://server/", "ParseException");
    private final static QName _DeleteMeet_QNAME = new QName("http://server/", "deleteMeet");
    private final static QName _RegistryResponse_QNAME = new QName("http://server/", "registryResponse");
    private final static QName _DeleteMeetResponse_QNAME = new QName("http://server/", "deleteMeetResponse");
    private final static QName _ClearMeetResponse_QNAME = new QName("http://server/", "clearMeetResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMeetingListResponse }
     * 
     */
    public GetMeetingListResponse createGetMeetingListResponse() {
        return new GetMeetingListResponse();
    }

    /**
     * Create an instance of {@link Registry }
     * 
     */
    public Registry createRegistry() {
        return new Registry();
    }

    /**
     * Create an instance of {@link AddMeetResponse }
     * 
     */
    public AddMeetResponse createAddMeetResponse() {
        return new AddMeetResponse();
    }

    /**
     * Create an instance of {@link QueryMeet }
     * 
     */
    public QueryMeet createQueryMeet() {
        return new QueryMeet();
    }

    /**
     * Create an instance of {@link ClearMeet }
     * 
     */
    public ClearMeet createClearMeet() {
        return new ClearMeet();
    }

    /**
     * Create an instance of {@link GetMeetingList }
     * 
     */
    public GetMeetingList createGetMeetingList() {
        return new GetMeetingList();
    }

    /**
     * Create an instance of {@link CheckIdResponse }
     * 
     */
    public CheckIdResponse createCheckIdResponse() {
        return new CheckIdResponse();
    }

    /**
     * Create an instance of {@link AddMeet }
     * 
     */
    public AddMeet createAddMeet() {
        return new AddMeet();
    }

    /**
     * Create an instance of {@link QueryMeetResponse }
     * 
     */
    public QueryMeetResponse createQueryMeetResponse() {
        return new QueryMeetResponse();
    }

    /**
     * Create an instance of {@link DeleteMeetResponse }
     * 
     */
    public DeleteMeetResponse createDeleteMeetResponse() {
        return new DeleteMeetResponse();
    }

    /**
     * Create an instance of {@link ClearMeetResponse }
     * 
     */
    public ClearMeetResponse createClearMeetResponse() {
        return new ClearMeetResponse();
    }

    /**
     * Create an instance of {@link RegistryResponse }
     * 
     */
    public RegistryResponse createRegistryResponse() {
        return new RegistryResponse();
    }

    /**
     * Create an instance of {@link DeleteMeet }
     * 
     */
    public DeleteMeet createDeleteMeet() {
        return new DeleteMeet();
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link CheckId }
     * 
     */
    public CheckId createCheckId() {
        return new CheckId();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMeet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "addMeet")
    public JAXBElement<AddMeet> createAddMeet(AddMeet value) {
        return new JAXBElement<AddMeet>(_AddMeet_QNAME, AddMeet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryMeetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "queryMeetResponse")
    public JAXBElement<QueryMeetResponse> createQueryMeetResponse(QueryMeetResponse value) {
        return new JAXBElement<QueryMeetResponse>(_QueryMeetResponse_QNAME, QueryMeetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearMeet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "clearMeet")
    public JAXBElement<ClearMeet> createClearMeet(ClearMeet value) {
        return new JAXBElement<ClearMeet>(_ClearMeet_QNAME, ClearMeet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeetingList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getMeetingList")
    public JAXBElement<GetMeetingList> createGetMeetingList(GetMeetingList value) {
        return new JAXBElement<GetMeetingList>(_GetMeetingList_QNAME, GetMeetingList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "checkIdResponse")
    public JAXBElement<CheckIdResponse> createCheckIdResponse(CheckIdResponse value) {
        return new JAXBElement<CheckIdResponse>(_CheckIdResponse_QNAME, CheckIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryMeet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "queryMeet")
    public JAXBElement<QueryMeet> createQueryMeet(QueryMeet value) {
        return new JAXBElement<QueryMeet>(_QueryMeet_QNAME, QueryMeet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMeetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "addMeetResponse")
    public JAXBElement<AddMeetResponse> createAddMeetResponse(AddMeetResponse value) {
        return new JAXBElement<AddMeetResponse>(_AddMeetResponse_QNAME, AddMeetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeetingListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getMeetingListResponse")
    public JAXBElement<GetMeetingListResponse> createGetMeetingListResponse(GetMeetingListResponse value) {
        return new JAXBElement<GetMeetingListResponse>(_GetMeetingListResponse_QNAME, GetMeetingListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Registry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "registry")
    public JAXBElement<Registry> createRegistry(Registry value) {
        return new JAXBElement<Registry>(_Registry_QNAME, Registry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "checkId")
    public JAXBElement<CheckId> createCheckId(CheckId value) {
        return new JAXBElement<CheckId>(_CheckId_QNAME, CheckId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMeet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "deleteMeet")
    public JAXBElement<DeleteMeet> createDeleteMeet(DeleteMeet value) {
        return new JAXBElement<DeleteMeet>(_DeleteMeet_QNAME, DeleteMeet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "registryResponse")
    public JAXBElement<RegistryResponse> createRegistryResponse(RegistryResponse value) {
        return new JAXBElement<RegistryResponse>(_RegistryResponse_QNAME, RegistryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMeetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "deleteMeetResponse")
    public JAXBElement<DeleteMeetResponse> createDeleteMeetResponse(DeleteMeetResponse value) {
        return new JAXBElement<DeleteMeetResponse>(_DeleteMeetResponse_QNAME, DeleteMeetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearMeetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "clearMeetResponse")
    public JAXBElement<ClearMeetResponse> createClearMeetResponse(ClearMeetResponse value) {
        return new JAXBElement<ClearMeetResponse>(_ClearMeetResponse_QNAME, ClearMeetResponse.class, null, value);
    }

}
