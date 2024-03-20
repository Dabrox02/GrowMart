import { getLs, getRequest } from "../util/Auth.js"
import { queries } from "../util/Routes.js";
import config from "./config.js";

const d = document;
const $ = (e) => d.querySelector(e);
const $a = (e) => d.querySelectorAll(e);

const capitalizeString = (str) => {
    return typeof str === 'string' ? str.charAt(0).toUpperCase() + str.slice(1) : str;
};

const convertToNormalCase = (str) => {
    if (str.includes('_')) {
        return str.split('_').map(word => capitalizeString(word)).join(' ');
    }
    if (str.match(/([a-z])([A-Z])/)) {
        return capitalizeString(str.replace(/([a-z])([A-Z])/g, '$1 $2'));
    }
    return capitalizeString(str);
};


const formatNestedObject = (obj) => {
    if (typeof obj !== 'object' || obj === null) {
        return obj;
    }
    let result = '';
    for (const [key, value] of Object.entries(obj)) {
        if (typeof value === 'object' && value !== null) {
            result += `${capitalizeString(key)}: ${formatNestedObject(value)}, `;
        } else {
            result += `${capitalizeString(key)}: ${value}, `;
        }
    }
    return result.slice(0, -2);
};

const loadTable = (obj) => {
    const keys = [...new Set(obj.flatMap(o => Object.keys(o)))];
    const columns = keys.map(key => ({ title: convertToNormalCase(key), data: key }));
    const tableData = obj.map(obj => {
        const row = {};
        keys.forEach(key => {
            const value = obj[key];
            row[key] = (typeof value === 'object' && value !== null) ? formatNestedObject(value) : (value !== undefined ? value : '');
        });
        return row;
    });

    new DataTable('#table-data', {
        language: {
            url: '//cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json',
        },
        columns: columns,
        data: tableData
    });
}

const showQuery = ({ query, response }) => {
    $("#content-query").innerHTML = "";
    $("#content-query").insertAdjacentHTML("beforeend", /*html */`
        <h2 class="text-justify">${query}</h2>
        <table id="table-data" class="table table-striped responsive"></table>
    `);
    loadTable(response);
}

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
                if (res && !res.error) {
                    showQuery({ query: data.description, response: res });
                }
            }
        }
    }
}