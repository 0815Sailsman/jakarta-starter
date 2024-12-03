FROM ubuntu
COPY target/starter-1.0-runner /home

# Expose the backend port
EXPOSE 8080

# Command to run the backend application
CMD ["/home/starter-1.0-runner"]
