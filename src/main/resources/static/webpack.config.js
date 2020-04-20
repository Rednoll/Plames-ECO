var packageJSON = require('./package.json');
var path = require('path');
var webpack = require('webpack');
module.exports = {
	entry: {
		
		register: "./register/main.jsx",
		login: "./login/main.jsx"
		
	},
	output: {
		path: path.join(__dirname, 'generated'),
		filename: '[name].bundle.js'
	},
	resolve: {
		extensions: ['.js', '.jsx']
	},
	module: {
        rules: [
            {
                test: /\.jsx?$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
				query: {
					presets: ["@babel/preset-env", "@babel/preset-react"]
				}
	       }
        ]
    },
};