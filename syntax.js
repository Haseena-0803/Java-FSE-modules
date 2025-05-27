// Declare event details
const eventName = "Community Cleanup Day";
const eventDate = "2025-06-15";
let availableSeats = 20;

// Function to update event info text
function updateEventInfo() {
  const info = `Event: ${eventName} | Date: ${eventDate} | Available Seats: ${availableSeats}`;
  document.getElementById('eventInfo').textContent = info;
}

// Register button handler to decrement seats
document.getElementById('registerBtn').addEventListener('click', () => {
  if (availableSeats > 0) {
    availableSeats--;  // decrement seat count
    updateEventInfo();
    alert("Registration successful!");
  } else {
    alert("Sorry, no seats available.");
  }
});

// Initial display
updateEventInfo();
