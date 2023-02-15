
package service;

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

    private final static QName _GetTDList_QNAME = new QName("http://server/", "getTDList");
    private final static QName _ClearTD_QNAME = new QName("http://server/", "clearTD");
    private final static QName _QueryTDResponse_QNAME = new QName("http://server/", "queryTDResponse");
    private final static QName _CheckIdResponse_QNAME = new QName("http://server/", "checkIdResponse");
    private final static QName _AddTDResponse_QNAME = new QName("http://server/", "addTDResponse");
    private final static QName _GetTDListResponse_QNAME = new QName("http://server/", "getTDListResponse");
    private final static QName _ClearTDResponse_QNAME = new QName("http://server/", "clearTDResponse");
    private final static QName _DeleteTDResponse_QNAME = new QName("http://server/", "deleteTDResponse");
    private final static QName _DeleteTD_QNAME = new QName("http://server/", "deleteTD");
    private final static QName _Registry_QNAME = new QName("http://server/", "registry");
    private final static QName _CheckId_QNAME = new QName("http://server/", "checkId");
    private final static QName _ParseException_QNAME = new QName("http://server/", "ParseException");
    private final static QName _AddTD_QNAME = new QName("http://server/", "addTD");
    private final static QName _QueryTD_QNAME = new QName("http://server/", "queryTD");
    private final static QName _RegistryResponse_QNAME = new QName("http://server/", "registryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteTD }
     * 
     */
    public DeleteTD createDeleteTD() {
        return new DeleteTD();
    }

    /**
     * Create an instance of {@link Registry }
     * 
     */
    public Registry createRegistry() {
        return new Registry();
    }

    /**
     * Create an instance of {@link ClearTDResponse }
     * 
     */
    public ClearTDResponse createClearTDResponse() {
        return new ClearTDResponse();
    }

    /**
     * Create an instance of {@link DeleteTDResponse }
     * 
     */
    public DeleteTDResponse createDeleteTDResponse() {
        return new DeleteTDResponse();
    }

    /**
     * Create an instance of {@link AddTDResponse }
     * 
     */
    public AddTDResponse createAddTDResponse() {
        return new AddTDResponse();
    }

    /**
     * Create an instance of {@link GetTDListResponse }
     * 
     */
    public GetTDListResponse createGetTDListResponse() {
        return new GetTDListResponse();
    }

    /**
     * Create an instance of {@link CheckIdResponse }
     * 
     */
    public CheckIdResponse createCheckIdResponse() {
        return new CheckIdResponse();
    }

    /**
     * Create an instance of {@link ClearTD }
     * 
     */
    public ClearTD createClearTD() {
        return new ClearTD();
    }

    /**
     * Create an instance of {@link QueryTDResponse }
     * 
     */
    public QueryTDResponse createQueryTDResponse() {
        return new QueryTDResponse();
    }

    /**
     * Create an instance of {@link GetTDList }
     * 
     */
    public GetTDList createGetTDList() {
        return new GetTDList();
    }

    /**
     * Create an instance of {@link RegistryResponse }
     * 
     */
    public RegistryResponse createRegistryResponse() {
        return new RegistryResponse();
    }

    /**
     * Create an instance of {@link AddTD }
     * 
     */
    public AddTD createAddTD() {
        return new AddTD();
    }

    /**
     * Create an instance of {@link QueryTD }
     * 
     */
    public QueryTD createQueryTD() {
        return new QueryTD();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTDList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getTDList")
    public JAXBElement<GetTDList> createGetTDList(GetTDList value) {
        return new JAXBElement<GetTDList>(_GetTDList_QNAME, GetTDList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearTD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "clearTD")
    public JAXBElement<ClearTD> createClearTD(ClearTD value) {
        return new JAXBElement<ClearTD>(_ClearTD_QNAME, ClearTD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryTDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "queryTDResponse")
    public JAXBElement<QueryTDResponse> createQueryTDResponse(QueryTDResponse value) {
        return new JAXBElement<QueryTDResponse>(_QueryTDResponse_QNAME, QueryTDResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "addTDResponse")
    public JAXBElement<AddTDResponse> createAddTDResponse(AddTDResponse value) {
        return new JAXBElement<AddTDResponse>(_AddTDResponse_QNAME, AddTDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTDListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getTDListResponse")
    public JAXBElement<GetTDListResponse> createGetTDListResponse(GetTDListResponse value) {
        return new JAXBElement<GetTDListResponse>(_GetTDListResponse_QNAME, GetTDListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearTDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "clearTDResponse")
    public JAXBElement<ClearTDResponse> createClearTDResponse(ClearTDResponse value) {
        return new JAXBElement<ClearTDResponse>(_ClearTDResponse_QNAME, ClearTDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "deleteTDResponse")
    public JAXBElement<DeleteTDResponse> createDeleteTDResponse(DeleteTDResponse value) {
        return new JAXBElement<DeleteTDResponse>(_DeleteTDResponse_QNAME, DeleteTDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "deleteTD")
    public JAXBElement<DeleteTD> createDeleteTD(DeleteTD value) {
        return new JAXBElement<DeleteTD>(_DeleteTD_QNAME, DeleteTD.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "addTD")
    public JAXBElement<AddTD> createAddTD(AddTD value) {
        return new JAXBElement<AddTD>(_AddTD_QNAME, AddTD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryTD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "queryTD")
    public JAXBElement<QueryTD> createQueryTD(QueryTD value) {
        return new JAXBElement<QueryTD>(_QueryTD_QNAME, QueryTD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "registryResponse")
    public JAXBElement<RegistryResponse> createRegistryResponse(RegistryResponse value) {
        return new JAXBElement<RegistryResponse>(_RegistryResponse_QNAME, RegistryResponse.class, null, value);
    }

}
