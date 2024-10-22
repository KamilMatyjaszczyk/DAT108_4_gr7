class DeltagerManager{
    #fornavn
    #etternavn
    #mobil
    #passord
    #passordRepetert
    #mann
    #kvinne
    constructor(root) {

        this.#fornavn = root.getElementsByTagName("input")[0];
        this.#etternavn = root.getElementsByTagName("input")[1];
        this.#mobil = root.getElementsByTagName("input")[2];
        this.#passord = root.getElementsByTagName("input")[3];
        this.#passordRepetert = root.getElementsByTagName("input")[4];
        this.#mann = root.getElementsByTagName("input")[5];
        this.#kvinne = root.getElementsByTagName("input")[6];

        const buttonEl = root.getElementsByTagName("button")[0];
        buttonEl.addEventListener("click", () => { this.submit() } )
    }

    submit() {

        if (!this.validity())
            console.log("error")
        else
            console.log("riktig")

    }

    validity() {

        const fornavnEl = this.#fornavn;
        const etternavnEl = this.#etternavn;
        const mobilEl = this.#mobil;
        const passordEl = this.#passord;
        const passordRepetertEl = this.#passordRepetert;
        const mann = this.#mann;
        const kvinne = this.#kvinne;

        //Sier at alle input må være gyldig før den returnerer true
        let svar = (fornavnEl.reportValidity() && etternavnEl.reportValidity() && mobilEl.reportValidity() && passordEl.reportValidity() && passordRepetertEl.reportValidity() && mann.reportValidity())

        let regexNavn = /^[A-ZØÆÅ][A-Za-zæøåÆØÅ\s\-]+$/g;
        let regexEtternavn = /^[A-ZØÆÅ][A-Za-zæøåÆØÅ\-]+$/g;
        let regexMobil = /^[0-9]{8}$/g;
        let regexPassord = /^(?=.*[A-Z])(?=.*\d).{6,}$/g;

        //FORNAVN
        if (!(fornavnEl.value.match(regexNavn))) { fornavnEl.setCustomValidity("Ugyldig fornavn, kan bare ha A-Å og første bokstav må være stor bokstav") }
        else { fornavnEl.setCustomValidity(''); }

        //ETTERNAVN
        if (!(etternavnEl.value.match(regexEtternavn))) { etternavnEl.setCustomValidity("Ugyldig etternavn, kan bare ha A-Å of første bokstav må være stor bokstav"); }
        else { etternavnEl.setCustomValidity(''); }

        //MOBIL
        if (!mobilEl.value.match(regexMobil)) {
            mobilEl.setCustomValidity("Ugyldig mobilnr, må være 8 siffer");
        } else {mobilEl.setCustomValidity('')}

        //PASSORD
        if (!passordEl.value.match(regexPassord)){passordEl.setCustomValidity("Må være minst 6 tegn, ETT tall og EN STOR bokstav");}
        else{passordEl.setCustomValidity('')}

        //PASSORD_REPETERT
        if (passordRepetertEl.value !== passordEl.value)
        { passordRepetertEl.setCustomValidity("Passord må være like"); }
        else { passordRepetertEl.setCustomValidity('') }

        //KJØNN

        if (!mann.checked && !kvinne.checked) { mann.setCustomValidity("Må velge kjønn") }
        else(mann.setCustomValidity(''))



        console.log("svar" +svar)

        return svar
    }
}

const rootElement = document.getElementById("root");
new DeltagerManager(rootElement);