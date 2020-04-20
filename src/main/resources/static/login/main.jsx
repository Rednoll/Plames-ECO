import React from 'react';
import ReactDOM from 'react-dom';
import TextField from "@material-ui/core/TextField";
import { withStyles } from "@material-ui/core/styles";
import { createMuiTheme, ThemeProvider } from '@material-ui/core/styles';

import styles from "./jss_styles.js";
import mainTheme from "../common/jss_styles.jsx";

let loginForm = null;

class LoginForm extends React.Component {

	constructor(props) {
		super(props);

		this.state = {

			loginValid: true,
			loginHelperText: "",
			passValid: true,
			passHelperText: "",
			showPass: false
		};
		
		loginForm = this;
	}

	render() {

		const { classes } = this.props;

		return (

			<form id="login-form" name="f" action="login" method="POST">

				<img id="login-plames-icon" src="../resources/common/images/plames-color-icon.svg"></img>

				<div id="login-form-fields-container">

					<ThemeProvider theme={mainTheme}>
						
						<TextField fullWidth id="login-field" name="username" InputProps={{ classes: { input: classes.loginFormFieldInput } }} className={classes.loginFormField} error={!this.state.loginValid} helperText={this.state.loginHelperText} label="Login" />
	
						<TextField fullWidth id="pass-field" name="password" InputProps={{ classes: { input: classes.loginFormFieldInput } }} className={classes.loginFormField} error={!this.state.passValid} helperText={this.state.passHelperText} label="Password" type={this.state.showPass ? "text" : "password"} />
					
					</ThemeProvider>

				</div>

			</form>
		);
	}
}

const StyledLoginForm = withStyles(styles)(LoginForm);

ReactDOM.render(<StyledLoginForm />, document.querySelector("#login-form-container"));