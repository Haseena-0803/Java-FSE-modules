const events = [
  { id: 1, name: "Jazz Night", category: "Music", seats: 10, registered: 0 },
  { id: 2, name: "Baking Workshop", category: "Cooking", seats: 5, registered: 0 },
  { id: 3, name: "Yoga Class", category: "Health", seats: 8, registered: 0 },
  { id: 4, name: "Rock Concert", category: "Music", seats: 15, registered: 0 },
];

// Get DOM elements
const eventList = document.getElementById("eventList");
const categoryFilter = document.getElementById("categoryFilter");
const searchInput = document.getElementById("searchInput");

// Function to render events
function renderEvents(filteredEvents) {
  eventList.innerHTML = "";

  filteredEvents.forEach(event => {
    const card = document.createElement("div");
    card.style.border = "1px solid #ccc";
    card.style.padding = "10px";
    card.style.margin = "10px 0";

    const title = document.createElement("h3");
    title.textContent = `${event.name} (${event.category})`;
    card.appendChild(title);

    const seatsInfo = document.createElement("p");
    seatsInfo.textContent = `Seats: ${event.seats} | Registered: ${event.registered}`;
    card.appendChild(seatsInfo);

    const btn = document.createElement("button");
    btn.textContent = "Register";
    btn.disabled = event.registered >= event.seats;
    btn.onclick = () => {
      if (event.registered < event.seats) {
        event.registered++;
        updateView();
      }
    };
    card.appendChild(btn);

    eventList.appendChild(card);
  });
}

// Filter and search combined
function updateView() {
  const category = categoryFilter.value;
  const searchText = searchInput.value.toLowerCase();

  let filtered = events;

  if (category) {
    filtered = filtered.filter(e => e.category === category);
  }

  if (searchText) {
    filtered = filtered.filter(e => e.name.toLowerCase().includes(searchText));
  }

  renderEvents(filtered);
}

// Event listeners
categoryFilter.onchange = updateView;
searchInput.onkeydown = (e) => {
  // On keydown, update view with a slight delay for input to register
  setTimeout(updateView, 100);
};

// Initial render
updateView();
