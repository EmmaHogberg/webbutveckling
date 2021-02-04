const storageType = window.localStorage;
const consentPropertyName = "cookie-consent";
const consentPopup = document.getElementById("consent-popup");
const acceptBtn = document.getElementById("accept");

const showPopup = () => !storageType.getItem(consentPropertyName);
const saveToStorage = () => storageType.setItem(consentPropertyName, true);

window.onload = () => {
	
	const acceptFn = () => {
        saveToStorage(storageType);
        consentPopup.classList.add("hidden");
		document.cookie = "cookie-consent=true"
    }
    acceptBtn.addEventListener("click", acceptFn);
	
	if (showPopup(storageType)) {
		setTimeout(() => {
            consentPopup.classList.remove("hidden");
        }, 2000);
	}
}
