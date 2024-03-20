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
                codeBoss: "7"
            }
        },
        query10: {
            description: "Returns the name of the sales representatives and the number of clients each one serves.",
            path: `/employeeAmountClients`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query11: {
            description: "How many employees are there in the company?",
            path: `/countEmployeesAmount`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query12: {
            description: "Obtain a list with the name of each client and the first and last name of their sales representative.",
            path: `/clients`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query13: {
            description: "Return the job title, first name, last name, and email of the company's CEO.",
            path: `/boss`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        }
    },
    offices: {
        mainRoute: "/office",
        query1: {
            description: "Return a list with the office code and the city where there are offices.",
            path: `/officeCode/city`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {}
        },
        query2: {
            description:
                "Return the offices where none of the employees who have been sales representatives for any client that has made a purchase of any product from the 'Frutales' range work.",
            path: `/noSalesRep`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                productRange: "frutales"
            }
        },
        query3: {
            description: "Return a list with the city and phone number of the offices in Spain.",
            path: `/country`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                country: "espana"
            }
        },
        query4: {
            description: "List the addresses of the offices that have clients in Fuenlabrada.",
            path: `/clients/city`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                city: "fuenlabrada"
            }
        }
    },
    orders: {
        mainRoute: "/order",
        query1: {
            description: "Return a list of all orders that were rejected in 2009.",
            path: `/rejectedYear`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                year: "2009"
            }
        },
        query2: {
            description: "How many orders are there in each state? Order the result in descending order by the number of orders.",
            path: `/ordersPerState`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query3: {
            description: "Return a list with the order code, customer code, expected date, and delivery date of orders that have not been delivered on time.",
            path: `/notInTime`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query4: {
            description: "Return a list of all orders that have been delivered in the month of January of any year.",
            path: `/deliveredMonth`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                month: "1"
            }
        },
        query5: {
            description: "Return a list with the order code, customer code, expected date, and delivery date of orders where the delivery date has been at least two days before the expected date.",
            path: `/beforeExpected`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query6: {
            description: "Return a list with the different states that an order can go through.",
            path: `/allStates`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        }
    },
    details: {
        mainRoute: "/orderDetail",
        query1: {
            description: "List the total sales of the products that have billed more than 3000 euros. It will display the name, units sold, total billed, and total billed with taxes (21% IVA).",
            path: `/productsBillingMoreThan`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                moreThan: "3000"
            }
        },
        query2: {
            description: "Return a list of the top 20 best-selling products and the total number of units sold for each one. The list should be sorted by the total number of units sold.",
            path: `/findBestSellingProductsLimit`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                limit: "20"
            }
        },
        query3: {
            description: "The total billing that the company has had throughout its history, indicating the taxable base, the VAT, and the total billed. The taxable base is calculated by adding the product cost multiplied by the number of units sold from the order detail table. The IVA is 21% of the taxable base, and the total is the sum of the previous two fields.",
            path: `/companyBilling`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query4: {
            description: "The total billing that the company has had throughout its history, indicating the taxable base, the VAT, and the total billed. The taxable base is calculated by summing the product cost multiplied by the number of units sold from the order detail table. The IVA is 21% of the taxable base, and the total is the sum of the previous two fields. Grouped by each product code.",
            path: `/companyBillingProductCode`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query5: {
            description: "The total billing that the company has had throughout its history, indicating the taxable base, the VAT, and the total billed. The taxable base is calculated by summing the product cost multiplied by the number of units sold from the order detail table. The IVA is 21% of the taxable base, and the total is the sum of the previous two fields. Grouped by product code filtered by codes starting with 'OR'.",
            path: `/companyBillingProductCodeBeginsWith`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                beginsWith: "or"
            }
        },
        query6: {
            description: "Calculate the sum of the total quantity of all products appearing in each of the orders.",
            path: `/amountProductsInOrder`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query7: {
            description: "Calculate the number of different products in each of the orders.",
            path: `/amountDistinctProductsInOrder`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        }
    },
    payments: {
        mainRoute: "/payment",
        query1: {
            description: "Show the total sum of all payments made for each of the years appearing in the payments table.",
            path: `/sumAllPaymentsYear`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        },
        query2: {
            description: "Return a list of all payments made in the year 2009 through PayPal. Sort the result from highest to lowest.",
            path: `/paymentMethodYear`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                method: "paypal",
                year: "2009"
            }
        },
        query3: {
            description: "Return a list with the customer code of those customers who made any payment in 2008. Please note that you should remove any duplicate customer codes.",
            path: `/clientCodes`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                year: "2008"
            }
        },
        query4: {
            description: "What was the average payment in 2009?",
            path: `/averagePaymentYear`,
            config: {
                method: "GET"
            },
            needParams: true,
            params: {
                year: "2009"
            }
        },
        query5: {
            description: "Return a list of all payment methods that appear in the payment table. Please note that duplicate payment methods should not appear.",
            path: `/allPaymentMethods`,
            config: {
                method: "GET"
            },
            needParams: false,
            params: {
            }
        }
    }
}