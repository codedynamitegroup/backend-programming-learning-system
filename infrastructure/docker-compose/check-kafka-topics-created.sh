#!/bin/bash
# check-kafka-topics-created.sh

expected_topics=(
  "code-question-update-request-to-core-service"
  "code-question-update-response-from-core-service"
  "core-question-request"
  "core-question-response"
  "core-user-request"
  "course-user-request"
  "code-assessment-user-request"
  "user-response"
  "core-organization-request"
  "course-organization-request"
  "organization-response"
  "calendar-event-update-request"
  "calendar-event-update-response"
)

apt-get update -y

yes | apt-get install kcat

echo "Waiting for Kafka topics to be created..."
# Loop until all topics are found
all_created=false
while ! all_created; do
  all_created=true  # Reset flag for each iteration

  for topic in "${expected_topics[@]}"; do
    if ! kcat -L -b kafka-broker-1:9092 | grep -q "$topic"; then
      echo "Topic '$topic' not yet created. Waiting..."
      all_created=false
      break  # Exit inner loop if any topic is missing
    fi
  done

  # Sleep for a short duration before checking again
  sleep 5  # Adjust sleep time as needed
done

echo "All expected topics created. Starting application..."
./cnb/process/web  # Assuming this starts the application