@artifact.package@import griffon.transform.Threading

class @artifact.name@ {
    def view

    @Threading(Threading.Policy.SKIP)
    def copyText = {
        view.output.text = "[COPY] ${view.input.text}"
    }
}
