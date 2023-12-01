<h1>Network Homework 1</h1>

# Project Idea
TCP and UDP program must implement a simple request-response example:

1) The client reads the line (request) from standard input, then sends it to the server.
2) Server reads the line from the socket and prints the incoming message from the client.
3) The server sends (response) back.

For example: the client sends "B001", the server sends "Seat, Ibiza, 2009,Orange". In case there is no match request, send "Vehicle is not found".

4) The client reads and prints the result from the socket.

- | Vehicle plate ID | Make | Model | Year | Colour | Owner Name | Owner ID |
  |------------------|------|-------|------|--------|------------|----------|
  |      B001        | Seat | Ibiza | 2009 | Orange |    SAed    |  9087654 | 

5) The client can make more requests, before closing the app.

The list available on the server:
- | Vehicle plate ID | Make | Model | Year | Colour | Owner Name | Owner ID |
  |------------------|------|-------|------|--------|------------|----------|
  |      B001        | Seat | Ibiza | 2009 | Orange |    SAed    |  9087654 |
  |      B002        | Hyundai | Kona | 2019 | White |    Sami    |  8750888 |
  |      A001        | VW | Polo | 2005 | black |    Noora    |  3467892 |
  |      C002        | Audi | A6 | 2020 | silver |    Hiba    |  0956784 |
  |      C003        | BMW | X7 | 2022 | brown |    Noah    |  9076045 |



# Steps to install Homework on your system
+ Download Homework 1 repository
+ Open Anaconda terminal and ```cd``` to the location where Programming_Education_Center is downloaded

