module.exports = function (config) {
    config.set({
        browsers: ['ChromeHeadless'],
        // The directory where the output file lives
        basePath: 'target',
        // The file itself
        files: ['test.js', 'mockServiceWorker.js'],
        frameworks: ['cljs-test'],
        plugins: ['karma-cljs-test', 'karma-chrome-launcher'],
        colors: true,
        logLevel: config.LOG_INFO,
        client: {
            args: ["shadow.test.karma.init"],
            singleRun: true
        },
        proxies: {
            "/mockServiceWorker.js": "/base/mockServiceWorker.js"
        }
    })
};