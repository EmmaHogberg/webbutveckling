const storageType = window.localStorage;
const consentPropertyName = "cookie-consent";
const consentPopup = document.getElementById("consent-popup");
const acceptBtn = document.getElementById("accept");
const closeBtn = document.querySelector("#close-button");

const showPopup = () => !storageType.getItem(consentPropertyName);
const saveToStorage = () => storageType.setItem(consentPropertyName, true);

// Function for accepting cookies
const acceptFn = () => {
  saveToStorage(storageType);
  consentPopup.classList.add("hidden");
  document.cookie = "cookie-consent=true";
};

// Funktion for hiding banner
const hideCookieBanner = () => {
  consentPopup.classList.add("hidden");
};

window.onload = () => {
  // Listen for click on accept button
  acceptBtn.addEventListener("click", acceptFn);

  // Listen for click on close button
  closeBtn.addEventListener("click", hideCookieBanner);

  if (showPopup(storageType)) {
    setTimeout(() => {
      consentPopup.classList.remove("hidden");
    }, 2000);
  }
};
