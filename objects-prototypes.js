// Event class definition
class Event {
  constructor(name, date, seats) {
    this.name = name;
    this.date = date;
    this.seats = seats;
    this.registrations = 0;
  }

  // Prototype method to check seat availability
  checkAvailability() {
    return this.seats > this.registrations;
  }
}

// Create events
const event1 = new Event("Tech Conference", "2025-09-10", 100);
const event2 = new Event("Art Workshop", "2025-07-15", 25);

// List to hold events
const events = [event1, event2];

// Display events info and keys/values
const eventList = document.getElementById("eventList");

events.forEach(event => {
  const li = document.createElement("li");

  // Object.entries() to get keys and values as string
  const entries = Object.entries(event)
    .map(([key, value]) => `${key}: ${value}`)
    .join(", ");

  li.textContent = `${event.name} (Date: ${event.date}) - Available Seats: ${event.checkAvailability() ? "Yes" : "No"} | Properties => ${entries}`;

  eventList.appendChild(li);
});
