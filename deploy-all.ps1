Write-Host "Deploiement des services..." -ForegroundColor Green

# Services d'infrastructure

kubectl apply -f Discovery-Service/Discovery-Deploy.yaml
kubectl apply -f Configuration_Service/Config-deploy.yaml
kubectl apply -f mysql-deployment.yaml
kubectl apply -f Gateway-Service/gateway-deployment.yaml
kubectl apply -f Security-Service/Security-deploy.yaml
#kubectl apply -f prometheus-deploy.yaml

kubectl apply -f Filiere_Service/filiere-deployment.yaml
kubectl apply -f Etudiant_Service/etudiant-deployment.yaml
Write-Host "Attente 30 secondes..." -ForegroundColor Yellow
Start-Sleep -Seconds 30

Write-Host "Deploiement termine !" -ForegroundColor Green
kubectl get pods