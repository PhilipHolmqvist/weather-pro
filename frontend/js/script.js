function search() {
    var searchText = document.getElementById("search").value;
    if (searchText) {
      // Redirect to search results page with the search text.
      window.location.href = "search.html?query=" + encodeURIComponent(searchText);
    }
  }
  
  function quickSearch(option) {
    // Redirect to quick search results page with the selected option
    window.location.href = "search.html?option=" + encodeURIComponent(option);
  }