package v_collections

fun example1(list: List<Int>) {

    // If a lambda has exactly one parameter, that parameter can be accessed as 'it'
    val positiveNumbers = list.filter { it > 0 }

    val squares = list.map { it * it }
}

fun Shop.getCitiesCustomersAreFrom(): Set<City> {
    // Return the set of cities the customers are from
    return this.customers.map { it.city }.toSet()
}

fun Shop.getCustomersFrom(city: City): List<Customer> {
    // Return a list of the customers who live in the given city
    return this.customers.filter { it.city == city }
}

//Note
fun whyMapOperationOnSetReturnsListNotSet() {
    class Client(val name: String, val city: String)

    val clients = setOf(Client("Noah", "Ottawa"), Client("Xavier", "Ottawa"))

    val cities = clients.map { it.city }

    // If map returned a set of cities (instead of a list):
    clients.size() != cities.size() // could be surprising!
}


