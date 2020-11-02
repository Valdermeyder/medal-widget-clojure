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