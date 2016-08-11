// Karma configuration
// Generated on Sun Jul 31 2016 11:37:13 GMT-0400 (EDT)
module.exports = function(config) {
    config.set({
        // base path that will be used to resolve all patterns (eg. files, exclude)
        basePath: '.',
        // frameworks to use
        // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
        frameworks: ['jasmine'],
        // list of files / patterns to load in the browser
        files: [
            "node_modules/angular/angular.js",
            "node_modules/angular-mocks/angular-mocks.js",
            "app*.js",
            "modules/**/*.module.js",
            "modules/**/*.js",
        ],
        // list of files to exclude
        exclude: [
            'karma.conf.js'
        ],
        // preprocess matching files before serving them to the browser
        // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
        preprocessors: {
            'modules/**/!(*(.test).js' : ['coverage'],
            'modules/**/*.js' : ['jshint'],
            'app*.js' : ['jshint', 'coverage']
        },
        // test results reporter to use
        // possible values: 'dots', 'progress'
        // available reporters: https://npmjs.org/browse/keyword/karma-reporter
        reporters: ['progress', 'dots', 'junit', 'coverage'],
        // web server port
        port: 9876,
        // enable / disable colors in the output (reporters and logs)
        colors: true,
        // level of logging
        // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
        logLevel: config.LOG_INFO,
        // enable / disable watching file and executing tests whenever any file changes
        autoWatch: false,
        // start these browsers
        // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
        browsers: ['PhantomJS'],
        // Continuous Integration mode
        // if true, Karma captures browsers, runs the tests and exits
        singleRun: true,
        // Concurrency level
        // how many browser should be started simultaneous
        concurrency: Infinity,
        jshint: {
            options: {
                curly: true,
                eqeqeq: true,
                immed: true,
                latedef: false,
                newcap: true,
                noarg: true,
                sub: true,
                undef: true,
                boss: true,
                devel: true,
                eqnull: true,
                browser: true,
                predef: {
                    angular: false,
                    describe: false,
                    it: false,
                    expect: false,
                    inject: false,
                    module: false,
                    beforeEach: false
                },
                globals: {
                    jasmine: true
                }
            },
            summary: true
        },
        junitReporter: {
            outputDir: '../../../target/karma/',
            useBrowserName: true
        },
        coverageReporter: {
            reporters: [
                {
                    type: 'cobertura',
                    dir: '../../../target/karma-coverage/'
                },
                {
                    type: 'text-summary'
                }
            ]
        }
    })
}
