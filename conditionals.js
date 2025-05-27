// Sample events array
const events = [
  { name: "Spring Festival", date: "2025-04-10", seats: 10 },
  { name: "Summer Gala", date: "2023-08-01", seats: 0 },      // past date and full
  { name: "Community Cleanup", date: "2025-06-20", seats: 5 },
  { name: "Food Fair", date: "2024-12-15", seats: 0 },       // full
];

// Helper function to check if date is in future
function isUpcoming(dateStr) {
  const eventDate = new Date(dateStr);
  const today = new Date();
  today.setHours(0,0,0,0);
  return eventDate >= today;
}

const eventList = document.getElementById('eventList');

events.forEach(event => {
  if (isUpcoming(event.date) && event.seats > 0) {
    // Create list item for valid events
    const li = document.createElement('li');
    li.textContent = `${event.name} - ${event.date} (Seats available: ${event.seats})`;

    // Add register button
    const btn = document.createElement('button');
    btn.textContent = "Register";
    btn.addEventListener('click', () => {
      try {
        if (event.seats <= 0) throw new Error("No seats available");
        event.seats--;
        li.textContent = `${event.name} - ${event.date} (Seats available: ${event.seats})`;
        li.appendChild(btn);
        alert("Registration successful!");
      } catch (err) {
        alert(`Error: ${err.message}`);
      }
    });

    li.appendChild(btn);
    eventList.appendChild(li);
  }
});
