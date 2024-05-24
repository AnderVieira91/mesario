<!DOCTYPE html>

<html lang="pt-BR" class="pf-m-redhat-font" >

    <head>
        <title>${msg("tituloCadastrar")}</title>
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
                        <h1 class="pf-c-title pf-m-3xl">${msg("tituloCadastrar")}</h1>
                        <p class="pf-c-login__main-header-desc">${msg("mensagemCadastrar")}</p>
                    </header>

                    <div class="pf-c-login__main-body">
                        <form class="pf-c-form" action="${url.registrationAction}" method="post">
                            <div class="pf-c-form__group">
                                <label class="pf-c-form__label" for="firstName">
                                    <span class="pf-c-form__label-text">
                                        ${msg("nome")}
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
                                        id="firstName"
                                        name="firstName"
                                        autocomplete="firstName"
                                        required />
                            </div>

                            <div class="pf-c-form__group">
                                <label class="pf-c-form__label" for="lastName">
                                    <span class="pf-c-form__label-text">
                                        ${msg("sobrenome")}
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
                                        id="lastName"
                                        name="lastName"
                                        autocomplete="lastName"
                                        required />
                            </div>

                            <div class="pf-c-form__group">
                                <label class="pf-c-form__label" for="email">
                                    <span class="pf-c-form__label-text">
                                        ${msg("email")}
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
                                        id="email"
                                        name="email"
                                        autocomplete="email"
                                        required />
                            </div>

                            <div class="pf-c-form__group">
                                <label class="pf-c-form__label" for="username">
                                    <span class="pf-c-form__label-text">
                                        ${msg("usuario")}
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
                                        id="username"
                                        name="username"
                                        autocomplete="username"
                                        required />
                            </div>

                            <div class="pf-c-form__group">
                                <label class="pf-c-form__label" for="password">
                                    <span class="pf-c-form__label-text">
                                        ${msg("senha")}
                                    </span>
                                    &nbsp;
                                    <span class="pf-c-form__label-required" aria-hidden="true">
                                        &#42;
                                    </span>
                                </label>

                                <input
                                        class="pf-c-form-control"
                                        input="true"
                                        type="password"
                                        id="password"
                                        name="password"
                                        autocomplete="new-password"
                                        required />
                            </div>
                            
                            <div class="pf-c-form__group">
                                <label class="pf-c-form__label" for="password-confirm">
                                    <span class="pf-c-form__label-text">
                                        ${msg("confirmarSenha")}
                                    </span>
                                    &nbsp;
                                    <span class="pf-c-form__label-required" aria-hidden="true">
                                        &#42;
                                    </span>
                                </label>

                                <input
                                        class="pf-c-form-control"
                                        input="true"
                                        type="password"
                                        id="password-confirm"
                                        name="password-confirm"
                                        required />
                            </div>

                            <div class="pf-c-form__group pf-m-action">
                                <button class="pf-c-button pf-m-primary pf-m-block" type="submit">
                                    ${msg("cadastrar")}
                                </button>
                            </div>
                        </form>
                    </div>

                    <footer class="pf-c-login__main-footer">
                        <div class="pf-c-login__main-footer-band">
                            <p class="pf-c-login__main-footer-band-item">
                                <a href="${url.loginUrl}">${msg("voltarTelaLogin")}</a>
                            </p>
                        </div>
                    </footer>
                </main>
            </div>
        </div>
    </body>

</html>
