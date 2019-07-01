namespace java com.inmobi.esg.heartbeatdbservice.thrift
namespace py com_inmobi_programmatics_cs.expression.exception

exception TInternalServerException {
    1: required string message;
}

exception TError {
    1: string code,
    2: string message
}

exception TServiceException {
    1: optional set<TError> errors
}
