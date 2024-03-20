import config from "../api/config.js";
import Constants from "./Constants.js";

export const routes = {
    root: [`${Constants.uri}/`, `${Constants.uri}/index.html`],
    home: `${Constants.uri}/pages/home.html`,
    login: `${Constants.uri}/pages/login.html`,
    register: `${Constants.uri}/pages/register.html`
}

export const queries = {
    products: {
        mainRoute: "/product",
        query1: {
            description: "Returns a list of all products that belong to the Ornamental range and have more than 100 units in stock. The list should be sorted by their selling price, with the highest-priced ones listed first.",
            path: `/productsRangeStock`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                range: "ornamentales",
                stock: "100"
            }
        },
        query2: {
            description: "Returns a list of products that have never appeared in an order.",
            path: `/noOrder`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {}
        },
        query3: {
            description: "Returns a list of products that have never appeared in an order. The result should display the name, description, and image of the product.",
            path: `/noOrder/all`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {}
        },
        query4: {
            description: "Calculates the selling price of the most expensive and cheapest products in a single query.",
            path: `/findPriceHighestLowest`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {}
        }
    },
    clients: {
        mainRoute: "/client",
        query1: {
            description: "Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.",
            path: `/salesRep/office`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query2: {
            description: "Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.",
            path: `/productRange/purchased`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query3: {
            description: "Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus representantes de ventas.",
            path: `/paid`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query4: {
            description: "Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.",
            path: `/order/notInTime`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query5: {
            description: "Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido.",
            path: `/order/noPaid/all`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query6: {
            description: "Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.",
            path: `/office/paid`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query7: {
            description: "Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.",
            path: `/office/noPaid`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query8: {
            description: "Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas.",
            path: `/noPaid`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query9: {
            description: "Devuelve un listado que muestre solamente los clientes que no han pagado.",
            path: `/noPaid/all`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query10: {
            description: "Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido.",
            path: `/noOrder/noPaid/all`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query11: {
            description: "Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.",
            path: `/noOrder/all`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query12: {
            description: "Calcula el número de clientes que no tiene asignado representante de ventas.",
            path: `/countClientsWithoutEmployee`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query13: {
            description: "¿Calcula cuántos clientes tiene cada una de las ciudades que empiezan por 'M'?",
            path: `/countClientsCityBeginWith`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                initialLetterCity: "M"
            }
        },
        query14: {
            description: "Calcula el número de clientes que tiene la empresa.",
            path: `/countClientsAmount`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query15: {
            description: "¿Cuántos clientes existen con domicilio en la ciudad de Madrid?",
            path: `/countClientsAmountCity`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                city: "madrid"
            }
        },
        query16: {
            description: "¿Cuántos clientes tiene cada país?",
            path: `/countByCountry`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query17: {
            description: "Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado deberá mostrar el nombre y los apellidos de cada cliente.",
            path: `/clientFirstLastPayment`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query18: {
            description: "Devuelve un listado con el nombre de los todos los clientes españoles.",
            path: `/clientCountry`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                country: "spain"
            }
        },
        query19: {
            description: "Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo representante de ventas tenga el código de empleado 11 o 30.",
            path: `/clientCityEmployee`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                city: "madrid",
                employeeCode: "11",
                employeeCode2: "30"
            }
        }
    },
    employees: {
        mainRoute: "/employee",
        query1: {
            description: "Returns a list with the names of the employees along with the names of their bosses.",
            path: `/with/boss`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query2: {
            description: "Returns a list that displays the name of each employee, the name of their immediate boss, and the name of their boss's boss.",
            path: `/with/boss/boss`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query3: {
            description: "Returns a list with the name, last name, and position of those employees who are not sales representatives.",
            path: `/noPosition`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                position: "representante ventas"
            }
        },
        query4: {
            description: "Returns a list that displays only the employees who do not have an associated office.",
            path: `/noOffice/all`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query5: {
            description:
                "Returns a list with the data of the employees who do not have associated clients and the name of their associated boss.",
            path: `/noClient/with/boss/all`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query6: {
            description:
                "Returns a list showing only the employees who do not have an associated client, along with the data of the office where they work.",
            path: `/noClient/office/all`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query7: {
            description:
                "Returns a list showing the employees who do not have an associated office and those who do not have an associated client.",
            path: `/noClient/noOffice/all`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query8: {
            description:
                "Returns a list showing only the employees who do not have an associated client.",
            path: `/noClient/all`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query9: {
            description:
                "Returns a list with the name, last name, and email of the employees whose boss has a boss code equal to 7.",
            path: `/name/surnames`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                codePass: "7"
            }
        }
    }
}