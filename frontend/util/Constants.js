const hostName = "127.0.0.1";
const port = "5500";
const protocol = "http:";
const staticResource = "";
const uri = `${protocol}//${hostName}:${port}${staticResource !== "" ? `/${staticResource}` : ""}`;

export default {
    hostName, port, protocol, staticResource, uri
}