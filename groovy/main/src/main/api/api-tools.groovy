package api

if (action) {
  action.sendJSPOutput(true)
  action.originalResponse.setHeader("Content-Type", "application/json; charset=UTF-8")
}

response.setHeader("Access-Control-Allow-Credentials", 'true')
response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"))
response.setHeader("Access-Control-Allow-Headers", 'content-type, cache-control, x-requested-with')
response.setHeader("Access-Control-Allow-Methods", "POST, PUT, DELETE, GET, OPTIONS")

if(request.getMethod().toLowerCase() == "options") {
  return
}
