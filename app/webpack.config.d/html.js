const HtmlWebpackPlugin = require('html-webpack-plugin');

config.plugins.push(
  new HtmlWebpackPlugin({
    template: 'kotlin/index.html',
    filename: 'index.html',
  })
);

module.exports = config;
