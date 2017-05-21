class NoSuchElement extends MyException {
    NoSuchElement(int number, String message) {
        super(number,message);
        this.detailText = "No such element";
    }
}
