import Axios from "axios";

export function updateRooms() {
  Axios.get("http://localhost:8080/customers")
    .then((response) => {
      // takes the given data path from the server API response
      const data = response.data._embedded.customers;

      const customers = data.map((c) => {
        return {
          nameF: c.firstName,
          nameL: c.lastName,
        };
      });

      console.log(customers);

      // dispatch the customers to the store
      return customers;
    })
    .catch((error) => console.log(error));
}
