# Bus Tracking Application

This is a Bus Tracking application for Android that uses Google Maps API to display bus locations and routes. The application is built using Java and Retrofit for API calls.<br>
Review: https://www.youtube.com/watch?v=XrivyB7F_Hk <br>

## Features

- Display bus locations on a map<br>
- View bus routes and schedules<br>
- Search for bus stops and routes<br>
- View detailed information about a specific bus route<br>

## Getting Started

### Prerequisites

- Android Studio<br>
- Java JDK<br>
- Google Maps API Key<br>

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/duybaodg/Bus_Tracking.git
   ```
2. Open the project in Android Studio.<br>
3. Add your Google Maps API Key to the `local.properties` file:
   ```properties
   MAPS_API_KEY=YOUR_API_KEY
   ```
4. Build and run the project on an emulator or physical device.

## Usage

- On the welcome screen, click "Login" to proceed to the main screen.<br>
- Use the bottom navigation bar to switch between Home, Map, and Schedule views.<br>
- On the Home screen, click on a bus item to view detailed information about the route.<br>
- On the Map screen, view the real-time location of buses.<br>
- On the Schedule screen, search for bus stops and view their schedules.<br>

## Dependencies

- Retrofit<br>
- Gson<br>
- OkHttp<br>
- Google Play Services Location<br>
- AndroidX Libraries<br>

## Acknowledgments

- [Google Maps API](https://developers.google.com/maps/documentation/android-sdk/get-api-key)<br>
- [Retrofit](https://square.github.io/retrofit/)<br>
- [Gson](https://github.com/google/gson)<br>
- [OkHttp](https://square.github.io/okhttp/)<br>
