<!DOCTYPE html>

<html lang="pt-BR" class="pf-m-redhat-font" >

    <head>
        <title>${msg("tituloLogin")}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="${url.resourcesPath}/images/seconci.jpg">
        <#if properties.styles?has_content>
            <#list properties.styles?split(' ') as style>
                <link href="${url.resourcesPath}/${style}" rel="stylesheet" />
            </#list>
        </#if>
    </head>

    <body>
        <div class="pf-c-login">
            <div class="pf-c-login__container">
                <header class="pf-c-login__header">
                    <img class="pf-c-brand" src="${url.resourcesPath}/images/seconci.jpg" alt="Seconci" />
                </header>

                <main class="pf-c-login__main">
                    <header class="pf-c-login__main-header">
                        <h1 class="pf-c-title pf-m-3xl">${msg("tituloAutenticacaoDuasEtapas")}</h1>
                    </header>

                    <div class="pf-c-login__main-body">
                        <form class="pf-c-form" action="${url.loginAction}" method="post">
                            <#if message?has_content>
                                <#if message.type == 'error'>
                                    <p class="pf-c-form__helper-text pf-m-error">
                                        <span class="pf-c-form__helper-text-icon">
                                            <i class="fas fa-exclamation-circle" aria-hidden="false"></i>
                                        </span>
                                        ${msg("codigoInvalido")}
                                    </p>
                                </#if>
                            </#if>

                            <div class="pf-c-form__group">
                                <#list otpLogin.userOtpCredentials as otpCredential>
                                    <p><strong>${otpCredential.userLabel}</strong></p>
                                </#list>
                            </div>

                            <div class="pf-c-form__group">
                                <label class="pf-c-form__label" for="password">
                                    <span class="pf-c-form__label-text">
                                        ${msg("codigoUsoUnico")}
                                    </span>
                                    &nbsp;
                                    <span class="pf-c-form__label-required" aria-hidden="true">
                                        &#42;
                                    </span>
                                </label>

                                <input
                                        class="pf-c-form-control"
                                        input="true"
                                        type="text"
                                        id="otp"
                                        name="otp"
                                        autocomplete="off"
                                        required />
                            </div>

                            <div class="pf-c-form__group pf-m-action">
                                <button class="pf-c-button pf-m-primary pf-m-block" id="kc-login" type="submit">
                                    ${msg("logar")}
                                </button>
                            </div>
                        </form>
                    </div>
                </main>
            </div>
        </div>
    </body>

</html>
