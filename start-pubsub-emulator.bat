@echo off
echo Starting Google Pub/Sub Emulator...

REM Start emulator in a new window, running inside the VM
start "PubSub Emulator" cmd /k "gcloud beta emulators pubsub start --host-port=0.0.0.0:8085"

REM Wait a bit for the emulator to boot
timeout /t 3 >nul

REM Pub/Sub emulator is local to the VM
set HOST_IP=localhost

REM Set environment variables for this window
set PUBSUB_EMULATOR_HOST=%HOST_IP%:8085
set PUBSUB_PROJECT_ID=local-dev

REM Recreate topics and subscriptions
echo Creating topics and subscriptions...
gcloud config set api_endpoint_overrides/pubsub http://%HOST_IP%:8085/ >nul

gcloud pubsub topics delete my-topic --project=local-dev --quiet >nul 2>&1
gcloud pubsub subscriptions delete my-sub --project=local-dev --quiet >nul 2>&1

gcloud pubsub topics create my-topic --project=local-dev >nul 2>&1
gcloud pubsub subscriptions create my-sub --topic=my-topic --project=local-dev >nul 2>&1

echo Pub/Sub emulator is ready.
echo Host: %HOST_IP%
echo Topic: my-topic
echo Subscription: my-sub

cmd