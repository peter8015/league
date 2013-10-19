/**
 *  platform JS 
 * 
 * summary: name space module
 *  @date 2011.10.21
 * @author Pan Shao Hua;
 */

function $_base_namespace() {
    var ns, d;
    ns = window;
    if (arguments[0]) {
        d = arguments[0].split(".");
        for (var i = 0; i < d.length; i++) {
            ns = ns[d[i]] = ns[d[i]] ? ns[d[i]] : {};
        }
    }
    return ns;
}
var base = window.base = $_base_namespace("base");
base.ns = $_base_namespace;
