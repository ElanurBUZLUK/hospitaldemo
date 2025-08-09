module.exports = function (config) {
  config.set({
    basePath: '',
    frameworks: ['jasmine', '@angular-devkit/build-angular'],
    plugins: [
      require('karma-jasmine'),
      require('karma-chrome-launcher'),
      require('karma-jasmine-html-reporter'),
      require('karma-coverage'),
      require('@angular-devkit/build-angular/plugins/karma')
    ],
    client: {
      jasmine: {
        // Özelleştirilmiş Jasmine ayarları (isteğe bağlı)
        random: false  // örnek: testleri rastgele çalıştırmayı kapatmak
      },
      clearContext: false  // Tarayıcıdaki Jasmine speclerin temizlenmesini engelle (fail detaylarını görmek için)
    },
    jasmineHtmlReporter: {
      suppressAll: true  // Duplicated trace'leri gizler
    },
    coverageReporter: {
      dir: require('path').join(__dirname, './coverage/<proje-ismi>'),
      subdir: '.',
      reporters: [{ type: 'html' }, { type: 'text-summary' }]
    },
    reporters: ['progress', 'kjhtml'],
    port: 9876,
    colors: true,
    logLevel: config.LOG_INFO,
    autoWatch: true,
    browsers: ['Chrome'],
    singleRun: false,
    restartOnFileChange: true
  });
};

