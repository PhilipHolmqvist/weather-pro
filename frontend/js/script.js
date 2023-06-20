
  const main = document.querySelector('main')

  let params = (new URL(document.location)).searchParams;
  weather = getWeather(params.get("q"));

  for(let i = 0; i < weather.length; i++){
    console.log(weather['klart'])
  }


  let htmlString = "";
  let cityName = "Helsingborg";
  let weatherType = "Cloudy";
  let windSpeed = "10";
  let rainChance = "0";
  let temperature = "23";
  let forecasterName = "klart"


  //Iterera genom JSON response från API.
  for(let i = 0; i < 4; i++){
    htmlString += `
    <div class="card">
      <img src="../images/${forecasterName}-logo.png" alt="${forecasterName}" width="80" height="50">
      <h2>${cityName}</h2>
      <h3>${weatherType}<span>Vind ${windSpeed}/s<span class="dot">•</span>Regn ${rainChance}</span></h3>
      <h1>${temperature}°</h1>
      <div class="sky">
        <div class="sun"></div>
        <div class="cloud">
          <div class="circle-small"></div>
          <div class="circle-tall"></div>
          <div class="circle-medium"></div>
        </div>
      </div>
    </div>`;
  }

main.innerHTML = htmlString;


function search() {
    var searchText = document.getElementById("search").value;
    if (searchText) {
      // Redirect to search results page with the search text.
      window.location.href = "search.html?q=" + encodeURIComponent(searchText);
      console.log('Search text: ' + searchText)
      getWeather(searchText);
    }
  }
  
function quickSearch(option) {
    // Redirect to quick search results page with the selected option
    window.location.href = "search.html?q=" + encodeURIComponent(option);
    console.log('Search text: ' + searchText)
    getWeather(searchText);
  }

async function getWeather(city){
    var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;
    
    if (city == '' || !format.test(city)){
      console.log('Input was invalid');
      return makeErrorMessage('Invalid search input!');
    }else{
      console.log('Input was valid!');
    }

    try {
      const response = await fetch('http://localhost:8080/weather/?q=' + city, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json'
        }
      });
  
      if (response.ok) {
        const weather = await response.json();
      } else {
        throw new Error('Failed to get weather for city: ' + city);
      }
    } catch (error) {
      console.error('Error retrieving weather:', error);
      return [];
    }
  }

//Search with press of enter key.
var input = document.getElementById("search");
input.addEventListener("keypress", function(event) {
    if (event.key === "Enter") {
      event.preventDefault();
      document.getElementById("search-button").click();
    }
  });


  