/**
 * === include here your page scripts ===
 */
const pageScripts = {
    home: './app/js/home.js',
    login: './app/js/login.js',
    register: './app/js/register.js'
}


/**
 * === dont change from here ===
 */
const path = require('path');
const CleanWebpackPlugin = require('clean-webpack-plugin');

const distFolder = 'app/dist'

module.exports = {
    entry: pageScripts,
    devtool: 'inline-source-map',
    plugins: [
        new CleanWebpackPlugin([distFolder])
    ],
    output: {
        filename: '[name].bundle.js',
        path: path.resolve(__dirname, distFolder)
    },
    mode: 'development'
};