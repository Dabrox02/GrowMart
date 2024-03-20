import { getLs, getRequest } from "../util/Auth.js"
import { queries } from "../util/Routes.js";
import config from "./config.js";

export const loadQuery = async (e) => {

    if (e.target.closest("#query")) {
        let el = e.target.closest("#query");
        let { type, queryNumber } = el.dataset;
        let host = config.uri;
        if (queries[type] && queries[type]['mainRoute']) {
            let mainRoute = queries[type]['mainRoute'];
            let data = queries[type][`query${queryNumber}`];
            let token = getLs("token");
            if (data) {
                let res = await getRequest(data, host, mainRoute, token);
                console.log(res);
            }
        }

    }

}