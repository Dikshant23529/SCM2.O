const currenttheme = localStorage.getItem("theme");

const drkbtn = document.getElementById("drkbtn");

drkbtn.addEventListener("click", () => {

    if (localStorage.getItem("theme") === "dark") {
    localStorage.setItem("theme", "light");
    document.querySelector("html").classList.replace("dark", "light");
    console.log("light mode enabled");
  } 
  
  else {
    localStorage.setItem("theme", "dark");
    document.querySelector("html").classList.replace("light", "dark");
    console.log("dark mode enabled");
  }

});
