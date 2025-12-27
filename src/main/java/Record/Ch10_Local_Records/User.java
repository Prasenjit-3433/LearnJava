package Record.Ch10_Local_Records;

public record User(String name, int age) {

    public void printAddress(String city, String country) {

        // Define a local record
        record Address(String city, String country) {

            public String fullAddress() {
                return city + ", " + country;
            }
        }

        Address address = new Address(city, country);
        System.out.println(name + " (" + age + ") lives at " + address.fullAddress());
    }
}
