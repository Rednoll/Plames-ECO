var packageJSON = require('./package.json');
var path = require('path');
var webpack = require('webpack');
module.exports = {
	entry: {
		
		register: "./src/main/resources/static/eco/register/main.jsx",
		login: "./src/main/resources/static/eco/login/main.jsx"
		
	},
	output: {
		path: path.join(__dirname, '/src/main/resources/static/eco/generated'),
		filename: '[name].bundle.js'
	},
	resolve: {
		extensions: ['.js', '.jsx', '.css'] 
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
			},
		   	{
				test: /\.css$/i,
				use: ['style-loader', 'css-loader'],
			},
        ]
    },
};