function search() {
    var searchText = document.getElementById("search").value;
    if (searchText) {
      // Redirect to search results page with the search text.
      window.location.href = "search.html?query=" + encodeURIComponent(searchText);
      console.log('Search text: ' + searchText)
      getWeather(searchText);
    }
  }
  
  function quickSearch(option) {
    // Redirect to quick search results page with the selected option
    window.location.href = "search.html?option=" + encodeURIComponent(option);
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
        return weather;
      } else {
        throw new Error('Failed to get weather for city: ' + city);
      }
    } catch (error) {
      console.error('Error retrieving weather:', error);
      return [];
    }
  }

  