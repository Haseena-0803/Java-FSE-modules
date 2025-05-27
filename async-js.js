const eventList = document.getElementById('eventList');
const spinner = document.getElementById('spinner');
const fetchBtn = document.getElementById('fetchBtn');
const fetchAsyncBtn = document.getElementById('fetchAsyncBtn');

// Mock API URL (you can replace with any valid JSON URL)
const mockAPI = 'https://jsonplaceholder.typicode.com/posts?_limit=5';

// Helper to display events from data
function displayEvents(events) {
  eventList.innerHTML = '';
  events.forEach(event => {
    const li = document.createElement('li');
    li.textContent = event.title || event.name || 'Unnamed event';
    eventList.appendChild(li);
  });
}

// Fetch with .then() and .catch()
function fetchWithThen() {
  spinner.style.display = 'block';
  eventList.innerHTML = '';

  fetch(mockAPI)
    .then(response => {
      if (!response.ok) throw new Error('Network response was not OK');
      return response.json();
    })
    .then(data => {
      displayEvents(data);
      spinner.style.display = 'none';
    })
    .catch(error => {
      spinner.style.display = 'none';
      eventList.innerHTML = 'Error fetching events: ' + error.message;
    });
}

// Fetch with async/await
async function fetchWithAsyncAwait() {
  spinner.style.display = 'block';
  eventList.innerHTML = '';

  try {
    const response = await fetch(mockAPI);
    if (!response.ok) throw new Error('Network response was not OK');
    const data = await response.json();
    displayEvents(data);
  } catch (error) {
    eventList.innerHTML = 'Error fetching events: ' + error.message;
  } finally {
    spinner.style.display = 'none';
  }
}

// Event listeners
fetchBtn.addEventListener('click', fetchWithThen);
fetchAsyncBtn.addEventListener('click', fetchWithAsyncAwait);
