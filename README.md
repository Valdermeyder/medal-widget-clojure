The widget shows up to 10 countries that have won the most medals of a given kind in the Olympics games. 

# Preparation
`npm install`

# Run local demo
`npm run dev`

# Embed widget
The widget could be embedded in an HTML page using pattern below

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Medal Widget Demo</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/utils.css">
    <link rel="stylesheet" href="/widget.css">
  <body>
    <div id="medal-widget"></div>
    <noscript>
      You need to enable JavaScript to run this app.
    </noscript>
    <script src="/js/main.js"></script>
    <script type="text/javascript">
      window.onload = function() {widget.medal.main.init('medal-widget', 'gold')}
    </script>
  </body>
</html>
```
# Tests
## Prepare environment
Run `npx msw init target/`
[`msw`](https://github.com/mswjs/msw) is used as api stub for test

## Run tests
### On changes
1. Open one terminal and run `npm run test:watch`
1. Open another terminal and run `npm test`

To stop watching terminate both run scripts
### On demand
1. Run `npm run test:compile`
1. Run `npm test -- --single-run`
