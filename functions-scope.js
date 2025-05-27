// Store events
const events = [];

// addEvent function to add new event
function addEvent(name, category, seats) {
  events.push({ name, category, seats, registrations: 0 });
}

// registerUser closure tracks total registrations per category
function registrationTracker(category) {
  let totalRegistrations = 0;

  return function register(event) {
    if (event.category === category && event.seats > event.registrations) {
      event.registrations++;
      totalRegistrations++;
      return true;
    }
    return false;
  };
}

// filterEventsByCategory takes a callback to filter dynamically
function filterEventsByCategory(callback) {
  return events.filter(callback);
}

// Add some events
addEvent("Charity Run", "Sports", 10);
addEvent("Cooking Class", "Food", 5);
addEvent("Yoga Workshop", "Health", 8);
addEvent("Football Match", "Sports", 15);

// Create a registration function for "Sports" category
const registerSports = registrationTracker("Sports");

// Display events filtered by category input
const eventList = document.getElementById("eventList");
const categoryInput = document.getElementById("categoryInput");
const filterBtn = document.getElementById("filterBtn");

function displayEvents(filteredEvents) {
  eventList.innerHTML = "";
  filteredEvents.forEach(event => {
    const li = document.createElement("li");
    li.textContent = `${event.name} [${event.category}] - Seats: ${event.seats}, Registered: ${event.registrations}`;

    const regBtn = document.createElement("button");
    regBtn.textContent = "Register";

    regBtn.addEventListener("click", () => {
      if (registerSports(event)) {
        li.textContent = `${event.name} [${event.category}] - Seats: ${event.seats}, Registered: ${event.registrations}`;
        li.appendChild(regBtn);
        alert("Registered successfully!");
      } else {
        alert("Registration full or category mismatch.");
      }
    });

    li.appendChild(regBtn);
    eventList.appendChild(li);
  });
}

// Initial display shows all events
displayEvents(events);

// Filter button event
filterBtn.addEventListener("click", () => {
  const category = categoryInput.value.trim();
  if (category === "") {
    displayEvents(events);
  } else {
    const filtered = filterEventsByCategory(event => event.category.toLowerCase() === category.toLowerCase());
    displayEvents(filtered);
  }
});
